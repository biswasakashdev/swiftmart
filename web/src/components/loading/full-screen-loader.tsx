import React from "react"
import { motion, AnimatePresence } from "framer-motion"
import { Store } from "lucide-react"

export interface FullScreenLoaderProps {
  isVisible?: boolean
  message?: string
}

export const FullScreenLoader: React.FC<FullScreenLoaderProps> = ({
  isVisible = true,
  message = "Loading your experience...",
}) => {
  return (
    <AnimatePresence>
      {isVisible && (
        <motion.div
          key="full-screen-loader"
          initial={{ opacity: 0 }}
          animate={{ opacity: 1 }}
          exit={{
            opacity: 0,
            transition: { duration: 0.3, ease: "easeInOut" },
          }}
          className="fixed inset-0 z-[9999] flex flex-col items-center justify-center bg-background/85 backdrop-blur-md select-none"
        >
          {/* Ambient Glow in the background */}
          <div className="pointer-events-none absolute h-72 w-72 rounded-full bg-primary/10 blur-3xl" />

          <motion.div
            initial={{ scale: 0.9, opacity: 0, y: 12 }}
            animate={{ scale: 1, opacity: 1, y: 0 }}
            exit={{ scale: 0.95, opacity: 0, y: -8 }}
            transition={{ duration: 0.35, ease: "easeOut" }}
            className="relative flex flex-col items-center text-center"
          >
            {/* Logo Container with Pulsing Ripple Effect */}
            <div className="relative mb-6 flex items-center justify-center">
              {/* Outer pulsing ring 1 */}
              <motion.div
                animate={{
                  scale: [1, 1.45, 1],
                  opacity: [0.35, 0, 0.35],
                }}
                transition={{
                  duration: 2.2,
                  repeat: Infinity,
                  ease: "easeInOut",
                }}
                className="absolute h-20 w-20 rounded-2xl bg-primary/20"
              />

              {/* Outer pulsing ring 2 */}
              <motion.div
                animate={{
                  scale: [1, 1.25, 1],
                  opacity: [0.5, 0.1, 0.5],
                }}
                transition={{
                  duration: 2.2,
                  repeat: Infinity,
                  ease: "easeInOut",
                  delay: 0.25,
                }}
                className="absolute h-18 w-18 rounded-2xl bg-primary/30"
              />

              {/* Main Branded Logo Badge */}
              <motion.div
                animate={{
                  y: [0, -4, 0],
                }}
                transition={{
                  duration: 3,
                  repeat: Infinity,
                  ease: "easeInOut",
                }}
                className="relative flex h-16 w-16 items-center justify-center rounded-2xl bg-primary text-primary-foreground shadow-xl shadow-primary/25"
              >
                <Store className="h-8 w-8" />
              </motion.div>
            </div>

            {/* Brand Title */}
            <motion.h2
              initial={{ opacity: 0, y: 4 }}
              animate={{ opacity: 1, y: 0 }}
              transition={{ delay: 0.1 }}
              className="text-xl font-bold tracking-tight text-foreground sm:text-2xl"
            >
              Swiftmart
            </motion.h2>

            {/* Loading Message */}
            <motion.p
              initial={{ opacity: 0 }}
              animate={{ opacity: 1 }}
              transition={{ delay: 0.18 }}
              className="mt-2 max-w-xs text-sm text-muted-foreground"
            >
              {message}
            </motion.p>

            {/* Elegant Loading Capsule / Bar */}
            <motion.div
              initial={{ opacity: 0, width: 0 }}
              animate={{ opacity: 1, width: 140 }}
              transition={{ delay: 0.25, duration: 0.4 }}
              className="mt-6 h-1 w-36 overflow-hidden rounded-full bg-muted"
            >
              <motion.div
                animate={{
                  x: ["-100%", "100%"],
                }}
                transition={{
                  duration: 1.4,
                  repeat: Infinity,
                  ease: "easeInOut",
                }}
                className="h-full w-1/2 rounded-full bg-primary"
              />
            </motion.div>

            {/* Subtle Staggered Progress Dots */}
            <div className="mt-4 flex items-center gap-1.5">
              {[0, 1, 2].map((i) => (
                <motion.span
                  key={i}
                  animate={{
                    opacity: [0.3, 1, 0.3],
                    scale: [0.85, 1.15, 0.85],
                  }}
                  transition={{
                    duration: 1.2,
                    repeat: Infinity,
                    delay: i * 0.2,
                    ease: "easeInOut",
                  }}
                  className="h-1.5 w-1.5 rounded-full bg-primary/70"
                />
              ))}
            </div>
          </motion.div>
        </motion.div>
      )}
    </AnimatePresence>
  )
}

export default FullScreenLoader
