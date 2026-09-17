import { createContext, useContext } from "react"

export interface LoadingContextType {
  // Full screen loading
  isFullLoading: boolean
  fullLoadingMessage?: string
  showFullLoader: (message?: string) => void
  hideFullLoader: () => void

  // Top progress bar loading
  isBarLoading: boolean
  progress: number
  startProgressBar: () => void
  completeProgressBar: () => void
  setProgressBar: (progress: number) => void

  // Helper utility to wrap any async operation
  withLoading: <T>(
    fn: () => Promise<T>,
    options?: { type?: "full" | "bar"; message?: string }
  ) => Promise<T>
}

export const LoadingContext = createContext<LoadingContextType>({
  isFullLoading: false,
  fullLoadingMessage: undefined,
  showFullLoader: () => {},
  hideFullLoader: () => {},
  isBarLoading: false,
  progress: 0,
  startProgressBar: () => {},
  completeProgressBar: () => {},
  setProgressBar: () => {},
  withLoading: async (fn) => fn(),
})

export const useLoading = () => {
  return useContext(LoadingContext)
}

export default useLoading
