import { RouterProvider } from "react-router"
import { routes } from "./routes"
import { AuthContextProvider } from "./providers/auth-provider"
import { TooltipProvider } from "./components/ui/tooltip"

export function App() {
  return (
    <AuthContextProvider>
      <TooltipProvider>
        <RouterProvider router={routes} />
      </TooltipProvider>
    </AuthContextProvider>
  )
}

export default App
