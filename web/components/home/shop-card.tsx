import { ArrowUpRight, ExternalLink, MoreVertical, Store } from "lucide-react"
import {
  Card,
  CardContent,
  CardDescription,
  CardFooter,
  CardHeader,
  CardTitle,
} from "../ui/card"
import {
  DropdownMenuTrigger,
  DropdownMenu,
} from "@/components/ui/dropdown-menu"
import {
  DropdownMenuContent,
  DropdownMenuItem,
  DropdownMenuSeparator,
} from "radix-ui/dropdown-menu"
import { Badge } from "@/components/ui/badge"
import { Separator } from "@/components/ui/separator"
import { Button } from "@/components/ui/button"

interface ShopCardProps {
  id: string
  name: string
  domain: string
  role: string
  status: string
  revenue: number
  productsCount: number
  ordersCount: number
}

export default function ShopCard({
  id,
  name,
  domain,
  role,
  status,
  revenue,
  productsCount,
  ordersCount,
}: ShopCardProps) {
  return (
    <Card className="flex h-full flex-col justify-between transition-all hover:border-muted-foreground/30 hover:shadow-sm">
      <CardHeader className="flex flex-row items-start justify-between space-y-0 pb-3">
        <div className="flex items-center gap-3">
          <div className="flex size-10 items-center justify-center rounded-lg border bg-muted/40">
            <Store className="size-5 text-foreground" />
          </div>
          <div>
            <CardTitle className="text-base font-medium">{name}</CardTitle>
            <CardDescription className="flex items-center gap-1 text-xs">
              {domain}
              <ExternalLink className="size-3" />
            </CardDescription>
          </div>
        </div>

        <DropdownMenu>
          <DropdownMenuTrigger asChild>
            <Button variant="ghost" size="icon" className="size-8">
              <MoreVertical className="size-4" />
              <span className="sr-only">Actions</span>
            </Button>
          </DropdownMenuTrigger>
          <DropdownMenuContent align="end">
            <DropdownMenuItem className="cursor-pointer">
              Dashboard
            </DropdownMenuItem>
            <DropdownMenuItem className="cursor-pointer">
              Store Settings
            </DropdownMenuItem>
            <DropdownMenuSeparator />
            <DropdownMenuItem className="cursor-pointer text-destructive">
              Delete Store
            </DropdownMenuItem>
          </DropdownMenuContent>
        </DropdownMenu>
      </CardHeader>

      <CardContent className="space-y-4 py-2">
        <div className="flex items-center justify-between text-xs">
          <span className="text-muted-foreground">Role</span>
          <Badge variant="secondary" className="font-normal">
            {role}
          </Badge>
        </div>
        <div className="flex items-center justify-between text-xs">
          <span className="text-muted-foreground">Status</span>
          <Badge
            variant={status === "Active" ? "default" : "outline"}
            className="font-normal"
          >
            {status}
          </Badge>
        </div>

        <Separator className="my-2" />

        {/* Store Statistics */}
        <div className="grid grid-cols-3 gap-2 text-center">
          <div className="rounded-md border bg-muted/20 p-2">
            <p className="text-[10px] text-muted-foreground uppercase">
              Revenue
            </p>
            <p className="text-xs font-medium">{revenue}</p>
          </div>
          <div className="rounded-md border bg-muted/20 p-2">
            <p className="text-[10px] text-muted-foreground uppercase">
              Orders
            </p>
            <p className="text-xs font-medium">{ordersCount}</p>
          </div>
          <div className="rounded-md border bg-muted/20 p-2">
            <p className="text-[10px] text-muted-foreground uppercase">
              Products
            </p>
            <p className="text-xs font-medium">{productsCount}</p>
          </div>
        </div>
      </CardContent>

      <CardFooter className="pt-2">
        <Button variant="outline" className="w-full justify-between" size="sm">
          <span>Manage Store</span>
          <ArrowUpRight className="size-4" />
        </Button>
      </CardFooter>
    </Card>
  )
}
