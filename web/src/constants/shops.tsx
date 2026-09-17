import type { Shop } from "@/types/shop.types"

export const MOCK_SHOPS: Shop[] = [
  {
    id: "shop-1",
    name: "Aether Apparel",
    lastActive: "1 day ago",
    role: "Owner",
    status: "Active",
    revenue: 42850.0,
    ordersCount: 384,
    productsCount: 42,
  },
  {
    id: "shop-2",
    name: "Urban Pulse Tech",
    lastActive: "2 days ago",
    role: "Owner",
    status: "Active",
    revenue: 128400.0,
    ordersCount: 1290,
    productsCount: 18,
  },
  {
    id: "shop-3",
    name: "Lumina Home & Decor",
    lastActive: "25/1/2026",
    role: "Admin",
    status: "Active",
    revenue: 18210.0,
    ordersCount: 142,
    productsCount: 95,
  },
  {
    id: "shop-4",
    name: "Botanica Organics",
    lastActive: "23/11/2022",
    role: "Member",
    status: "Draft",
    revenue: 0.0,
    ordersCount: 0,
    productsCount: 6,
  },
]
