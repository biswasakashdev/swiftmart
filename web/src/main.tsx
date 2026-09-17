import { StrictMode } from "react"
import { createRoot } from "react-dom/client"

import "./index.css"
import App from "./App.tsx"
import { ThemeProvider } from "@/components/theme-provider.tsx"
import { LoadingProvider } from "@/providers/loading-provider"
import { GlobalLoading } from "@/components/loading"

createRoot(document.getElementById("root")!).render(
  <StrictMode>
    <ThemeProvider>
      <LoadingProvider>
        <GlobalLoading />
        <App />
      </LoadingProvider>
    </ThemeProvider>
  </StrictMode>
)
