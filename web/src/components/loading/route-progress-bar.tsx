import { useEffect, useRef } from "react"
import { useLocation, useNavigation } from "react-router"
import useLoading from "@/context/loading.context"

/**
 * RouteProgressBar automatically triggers the top loading bar on route changes
 * and navigation transitions. Must be mounted inside a Router context.
 */
export const RouteProgressBar = () => {
  const { startProgressBar, completeProgressBar } = useLoading()
  const location = useLocation()
  const navigation = useNavigation()
  const prevPathRef = useRef(location.pathname)

  // 1. Listen for React Router navigation state transitions (e.g. loaders / actions)
  useEffect(() => {
    if (navigation.state === "loading" || navigation.state === "submitting") {
      startProgressBar()
    } else {
      completeProgressBar()
    }
  }, [navigation.state, startProgressBar, completeProgressBar])

  // 2. Listen for route / URL changes
  useEffect(() => {
    if (prevPathRef.current !== location.pathname) {
      prevPathRef.current = location.pathname
      startProgressBar()
      const timer = setTimeout(() => {
        completeProgressBar()
      }, 200)

      return () => clearTimeout(timer)
    }
  }, [location.pathname, startProgressBar, completeProgressBar])

  return null
}

export default RouteProgressBar
