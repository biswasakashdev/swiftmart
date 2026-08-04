"use client"

import HomeMain from "@/components/home/home-main-section"
import HomeSidebar from "@/components/home/home-sidebar"
import { SidebarProvider } from "@/components/ui/sidebar"
import { Shop } from "@/types/shop.types"
import { AxiosInstance } from "axios"
import { usePathname } from "next/navigation"

const currentUser = {
  name: "Alex Morgan",
  email: "alex.morgan@dev.co",
  avatar: "https://images.unsplash.com/photo-1534528741775-53994a69daeb?w=150",
}

export default function HomePage() {
  return (
    <SidebarProvider>
      {/* Collapsible Sidebar */}
      <HomeSidebar />

      <main className="flex min-h-screen w-full bg-background">
        {/* Main Content Area */}
        <HomeMain />
      </main>
    </SidebarProvider>
  )
}
