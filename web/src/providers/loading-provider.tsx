import { useState, useCallback, useRef, useEffect } from "react"
import {
  LoadingContext,
  type LoadingContextType,
} from "@/context/loading.context"

export const LoadingProvider = ({
  children,
}: {
  children: React.ReactNode
}) => {
  // Full-screen loader states
  const [isFullLoading, setIsFullLoading] = useState<boolean>(false)
  const [fullLoadingMessage, setFullLoadingMessage] = useState<
    string | undefined
  >(undefined)

  // Top progress bar states
  const [isBarLoading, setIsBarLoading] = useState<boolean>(false)
  const [progress, setProgress] = useState<number>(0)

  const progressTimerRef = useRef<ReturnType<typeof setInterval> | null>(null)
  const completeTimeoutRef = useRef<ReturnType<typeof setTimeout> | null>(null)

  // Clear all pending timers
  const clearTimers = useCallback(() => {
    if (progressTimerRef.current) {
      clearInterval(progressTimerRef.current)
      progressTimerRef.current = null
    }
    if (completeTimeoutRef.current) {
      clearTimeout(completeTimeoutRef.current)
      completeTimeoutRef.current = null
    }
  }, [])

  useEffect(() => {
    return () => {
      clearTimers()
    }
  }, [clearTimers])

  // Full-screen loader controls
  const showFullLoader = useCallback((message?: string) => {
    setFullLoadingMessage(message)
    setIsFullLoading(true)
  }, [])

  const hideFullLoader = useCallback(() => {
    setIsFullLoading(false)
    setFullLoadingMessage(undefined)
  }, [])

  // Top progress bar controls
  const startProgressBar = useCallback(() => {
    clearTimers()
    setIsBarLoading(true)
    setProgress(15)

    // Simulate organic deceleration (trickle)
    progressTimerRef.current = setInterval(() => {
      setProgress((prev) => {
        if (prev >= 90) {
          // Stay at 90% until explicitly completed
          return prev
        }
        // As progress gets higher, increment gets smaller
        const diff = 90 - prev
        const increment = Math.max(1, Math.floor(Math.random() * (diff * 0.25)))
        return Math.min(prev + increment, 90)
      })
    }, 250)
  }, [clearTimers])

  const completeProgressBar = useCallback(() => {
    if (progressTimerRef.current) {
      clearInterval(progressTimerRef.current)
      progressTimerRef.current = null
    }

    setProgress(100)

    completeTimeoutRef.current = setTimeout(() => {
      setIsBarLoading(false)
      setProgress(0)
    }, 300)
  }, [])

  const setProgressBar = useCallback((val: number) => {
    setProgress(Math.min(Math.max(val, 0), 100))
  }, [])

  // Helper utility to wrap any async operation
  const withLoading = useCallback(
    async <T,>(
      fn: () => Promise<T>,
      options?: { type?: "full" | "bar"; message?: string }
    ): Promise<T> => {
      const type = options?.type || "bar"

      if (type === "full") {
        showFullLoader(options?.message)
      } else {
        startProgressBar()
      }

      try {
        return await fn()
      } finally {
        if (type === "full") {
          hideFullLoader()
        } else {
          completeProgressBar()
        }
      }
    },
    [showFullLoader, hideFullLoader, startProgressBar, completeProgressBar]
  )

  const value: LoadingContextType = {
    isFullLoading,
    fullLoadingMessage,
    showFullLoader,
    hideFullLoader,
    isBarLoading,
    progress,
    startProgressBar,
    completeProgressBar,
    setProgressBar,
    withLoading,
  }

  return (
    <LoadingContext.Provider value={value}>{children}</LoadingContext.Provider>
  )
}

export default LoadingProvider
