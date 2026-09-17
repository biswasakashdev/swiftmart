import { createBrowserRouter, Navigate } from "react-router"
import App from "@/App"
import HomePage from "@/pages/home.page"
import AuthPage from "@/pages/auth.page"
import ShopPage from "@/pages/shop.page"
import LandingPage from "./pages/landing.page"

export const routes = createBrowserRouter([
  {
    path: "/",
    Component: App,
    children: [
      {
        index: true,
        Component: LandingPage,
      },
      {
        path: "home",
        Component: HomePage,
        children: [
          {
            path: ":shop-id",
            Component: ShopPage,
          },
        ],
      },
      {
        path: "auth",
        Component: AuthPage,
      },
    ],
  },
  {
    path: "*",
    element: <Navigate to="/home" />,
  },
])
