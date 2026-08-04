export interface Shop {
  id: string
  name: string
  domain: string
  role: "Owner" | "Admin" | "Member"
  status: "Active" | "Maintenance" | "Draft"
  revenue: number
  ordersCount: number
  productsCount: number
}
