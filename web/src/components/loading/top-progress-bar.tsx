import React from "react"
import { motion, AnimatePresence } from "framer-motion"

export interface TopProgressBarProps {
  isVisible?: boolean
  progress?: number // 0 - 100
}

export const TopProgressBar: React.FC<TopProgressBarProps> = ({
  isVisible = false,
  progress = 0,
}) => {
  return (
    <AnimatePresence>
      {isVisible && (
        <motion.div
          key="top-progress-bar"
          initial={{ opacity: 0 }}
          animate={{ opacity: 1 }}
          exit={{ opacity: 0, transition: { duration: 0.25, ease: "easeOut" } }}
          className="pointer-events-none fixed top-0 right-0 left-0 z-9999 h-0.75 overflow-hidden"
        >
          {/* Main Progress Fill */}
          <motion.div
            className="relative h-full bg-primary"
            initial={{ width: "0%" }}
            animate={{ width: `${Math.min(Math.max(progress, 0), 100)}%` }}
            transition={{
              type: "spring",
              damping: 25,
              stiffness: 120,
              mass: 0.5,
            }}
          >
            {/* Glowing Trailing Edge (Head Glow) */}
            <div className="absolute top-0 right-0 h-full w-24 bg-linear-to-r from-transparent via-primary/50 to-primary shadow-[0_0_12px_rgba(var(--color-primary),0.8),0_0_4px_rgba(var(--color-primary),0.9)]" />

            {/* Shimmer Light Reflection Effect */}
            <motion.div
              animate={{
                x: ["-100%", "200%"],
              }}
              transition={{
                duration: 1.5,
                repeat: Infinity,
                ease: "linear",
              }}
              className="absolute inset-0 w-1/3 bg-linear-to-r from-transparent via-white/25 to-transparent"
            />
          </motion.div>
        </motion.div>
      )}
    </AnimatePresence>
  )
}

export default TopProgressBar
