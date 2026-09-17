import React from "react"
import useLoading from "@/context/loading.context"
import { FullScreenLoader } from "./full-screen-loader"
import { TopProgressBar } from "./top-progress-bar"

export const GlobalLoading: React.FC = () => {
  const { isFullLoading, fullLoadingMessage, isBarLoading, progress } =
    useLoading()

  return (
    <>
      {/* Top progress bar for route and granular changes */}
      <TopProgressBar isVisible={isBarLoading} progress={progress} />

      {/* Full-screen animated screen for major operations / initial fetching */}
      <FullScreenLoader
        isVisible={isFullLoading}
        message={fullLoadingMessage}
      />
    </>
  )
}

export default GlobalLoading
