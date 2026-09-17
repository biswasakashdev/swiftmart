import { Separator } from "@/components/ui/separator"
import { SidebarInset, SidebarTrigger } from "@/components/ui/sidebar"

import { Button } from "@/components/ui/button"
import { Plus, Search, Store } from "lucide-react"

import { Badge } from "@/components/ui/badge"
import { Input } from "@/components/ui/input"
import { motion, type Variants } from "framer-motion"

import { type Shop } from "@/types/shop.types"
import { use, useEffect, useState } from "react"
import { PrimaryDetails } from "./primary-details"
import ShopCard from "./shop-card"
import useAuthContext from "@/context/auth.context"
import { MOCK_SHOPS } from "@/constants/shops"

// --- Framer Motion Animations ---
const containerVariants: Variants = {
  hidden: { opacity: 0 },
  visible: {
    opacity: 1,
    transition: {
      staggerChildren: 0.06,
    },
  },
}

const cardVariants: Variants = {
  hidden: { opacity: 0, y: 12 },
  visible: {
    opacity: 1,
    y: 0,
    transition: { duration: 0.25, ease: "easeOut" },
  },
}

export default function HomeMain() {
  const [shopList, setShopList] = useState<Shop[]>([])
  const [searchQuery, setSearchQuery] = useState("")

  const { client } = useAuthContext()

  useEffect(() => {
    const fetchShopList = async () => {
      const gpqlQuery = {
        query: `
          query GetShops($query: String!){
            shops(query: $query){
              id,
              name,
              role,
              status,
              revenue,
              ordersCount,
              productsCount
            }
          }
        `,
        variables: {
          query: searchQuery,
        },
      }
      const res = await client.post("/api/v1/graph", gpqlQuery)

      console.log(res.data)

      setShopList(MOCK_SHOPS)
    }

    const timeOut = setTimeout(() => {
      fetchShopList()
    }, 500)

    return clearTimeout(timeOut)
  }, [searchQuery, setShopList, client])

  return (
    <>
      <SidebarInset className="flex-1 overflow-x-hidden">
        {/* Header */}
        <header className="sticky top-0 z-10 flex h-16 items-center justify-between gap-4 border-b bg-background/95 px-6 backdrop-blur">
          <div className="flex items-center gap-4">
            <SidebarTrigger />
            <Separator orientation="vertical" className="h-6" />
            <div>
              <h1 className="text-lg font-semibold">Stores Dashboard</h1>
            </div>
          </div>
          <div className="flex items-center gap-3">
            <Button size="sm">
              <Plus className="mr-2 size-4" />
              Create New Store
            </Button>
          </div>
        </header>

        {/* Main Dashboard Section */}
        <main className="p-6">
          <div className="flex flex-col gap-6">
            {/* 1. Add the Metrics Analytics Section Here */}
            <PrimaryDetails />

            {/* Search and Filters Bar */}
            <div className="flex flex-col gap-4 sm:flex-row sm:items-center sm:justify-between">
              <div className="relative w-full max-w-sm">
                <Search className="absolute top-2.5 left-2.5 size-4 text-muted-foreground" />
                <Input
                  type="search"
                  placeholder="Search stores or domains..."
                  className="pl-8"
                  value={searchQuery}
                  onChange={(e) => setSearchQuery(e.target.value)}
                />
              </div>
              <div className="flex items-center gap-2">
                <Badge variant="outline" className="px-3 py-1 font-normal">
                  Total Stores: {shopList.length}
                </Badge>
              </div>
            </div>

            {/* Shops Grid */}
            <motion.div
              variants={containerVariants}
              initial="hidden"
              animate="visible"
              className="grid gap-4 md:grid-cols-2 lg:grid-cols-2 xl:grid-cols-3"
            >
              {/* <ShopsGrid shopListPromise={}/> */}
            </motion.div>

            {/* Empty State */}
            {/* 
            {shopList.length === 0 && (
              
            )} */}
          </div>
        </main>
      </SidebarInset>
    </>
  )
}

export const ShopsGrid = ({
  shopListPromise,
  searchQuery,
}: {
  shopListPromise: Promise<Shop[]>
  searchQuery: string
}) => {
  const shopList = use(shopListPromise)

  if (shopList.length === 0) {
    return (
      <div className="flex min-h-75 flex-col items-center justify-center rounded-lg border border-dashed p-8 text-center">
        <div className="flex size-12 items-center justify-center rounded-full bg-muted">
          <Store className="size-6 text-muted-foreground" />
        </div>
        <h3 className="mt-4 text-sm font-semibold">No stores found</h3>

        {searchQuery.length !== 0 && (
          <p className="mt-1 text-xs text-muted-foreground">
            No matching stores were found for &quot;{searchQuery}
            &ldquo;.
          </p>
        )}
      </div>
    )
  }

  return (
    <>
      {shopList.map((shop) => (
        <motion.div key={shop.id} variants={cardVariants}>
          <ShopCard {...shop} />
        </motion.div>
      ))}
    </>
  )
}
