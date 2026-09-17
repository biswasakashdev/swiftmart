"use client"

import { motion, Variants } from "framer-motion"
import {
  ShoppingBag,
  DollarSign,
  Users,
  TrendingUp,
  ArrowUpRight,
  ArrowDownRight,
} from "lucide-react"

import { Card, CardContent, CardHeader, CardTitle } from "@/components/ui/card"
import { Badge } from "@/components/ui/badge"
import { Suspense, use } from "react"
import { AxiosInstance } from "axios"
import useAuthContext from "@/context/auth.context"
import { Skeleton } from "../ui/skeleton"

interface MetricCardProps {
  title: string
  value: string
  change: string
  isPositive: boolean
  timeframe: string
}

const metricsData: MetricCardProps[] = [
  {
    title: "Total Revenue",
    value: "$189,460.00",
    change: "+12.5%",
    isPositive: true,
    timeframe: "from last month",
  },
  {
    title: "Total Orders",
    value: "1,816",
    change: "+8.2%",
    isPositive: true,
    timeframe: "from last month",
  },
  {
    title: "Active Customers",
    value: "3,420",
    change: "+18.4%",
    isPositive: true,
    timeframe: "from last month",
  },
  {
    title: "Avg. Conversion Rate",
    value: "3.24%",
    change: "-0.4%",
    isPositive: false,
    timeframe: "from last month",
  },
]

const containerVariants: Variants = {
  hidden: { opacity: 0 },
  visible: {
    opacity: 1,
    transition: {
      staggerChildren: 0.05,
    },
  },
}

const itemVariants: Variants = {
  hidden: { opacity: 0, y: 10 },
  visible: {
    opacity: 1,
    y: 0,
    transition: { duration: 0.2, ease: "easeOut" },
  },
}

const fecthDetails = (client: AxiosInstance): Promise<MetricCardProps[]> => {
  return new Promise((resl) => {
    setTimeout(() => {
      resl(metricsData)
    }, 3000)
  })
}

export function PrimaryDetails() {
  const { gpqlClient } = useAuthContext()

  const cardsPromise = fecthDetails(gpqlClient)

  return (
    <motion.div
      variants={containerVariants}
      initial="hidden"
      animate="visible"
      className="grid gap-4 sm:grid-cols-2 lg:grid-cols-4"
    >
      <Suspense fallback={<MetricsCardSkeleton />}>
        <MetricsCards cardsPromise={cardsPromise} />
      </Suspense>
    </motion.div>
  )
}

export const MetricsCards = ({
  cardsPromise,
}: {
  cardsPromise: Promise<MetricCardProps[]>
}) => {
  const metrics = use(cardsPromise)

  return (
    <>
      {metrics.map((metric) => {
        return (
          <motion.div key={metric.title} variants={itemVariants}>
            <Card className="transition-all hover:border-muted-foreground/30">
              <CardHeader className="flex flex-row items-center space-y-0 pb-2">
                <CardTitle className="text-sm font-medium text-muted-foreground">
                  {metric.title}
                </CardTitle>
              </CardHeader>
              <CardContent>
                <div className="text-2xl font-bold tracking-tight">
                  {metric.value}
                </div>
                <div className="mt-1 flex items-center gap-1.5 text-xs">
                  <Badge
                    variant={metric.isPositive ? "secondary" : "outline"}
                    className={`flex items-center gap-0.5 px-1.5 py-0.5 text-[11px] font-medium ${
                      metric.isPositive
                        ? "text-emerald-600 dark:text-emerald-400"
                        : "text-rose-600 dark:text-rose-400"
                    }`}
                  >
                    {metric.isPositive ? (
                      <ArrowUpRight className="size-3" />
                    ) : (
                      <ArrowDownRight className="size-3" />
                    )}
                    {metric.change}
                  </Badge>
                  <span className="text-muted-foreground">
                    {metric.timeframe}
                  </span>
                </div>
              </CardContent>
            </Card>
          </motion.div>
        )
      })}
    </>
  )
}

export function MetricsCardSkeleton() {
  return (
    <>
      {Array.from({ length: 4 }).map((_, i) => (
        <Card key={i} className="transition-all">
          <CardHeader className="flex flex-row items-center justify-between space-y-0 pb-2">
            {/* Title Skeleton */}
            <Skeleton className="h-4 w-24" />
            {/* Icon Container Skeleton */}
            <Skeleton className="size-8 rounded-md" />
          </CardHeader>
          <CardContent>
            {/* Metric Value Skeleton */}
            <Skeleton className="h-8 w-28 tracking-tight" />
            {/* Badge & Timeframe Skeleton */}
            <div className="mt-2 flex items-center gap-1.5">
              <Skeleton className="h-5 w-16 rounded-full" />
              <Skeleton className="h-3 w-20" />
            </div>
          </CardContent>
        </Card>
      ))}
    </>
  )
}
