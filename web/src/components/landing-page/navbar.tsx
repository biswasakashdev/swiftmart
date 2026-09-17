"use client"
import { Button } from "@/components/ui/button"
import { SwiftmartLogo } from "@/components/swiftmart-logo"
import { Link, useLocation } from "react-router"

export const Navbar = () => {
  const location = useLocation()

  return (
    <header className="sticky top-0 z-50 flex w-full justify-center border-b bg-background/95 backdrop-blur supports-backdrop-filter:bg-background/60">
      <div className="container flex h-16 items-center justify-between px-4 sm:px-8">
        <SwiftmartLogo />
        {location.pathname !== "/auth" && (
          <Button asChild variant="default" size="sm">
            <Link to="/auth">Log In</Link>
          </Button>
        )}
      </div>
    </header>
  )
}
