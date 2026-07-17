import { ShoppingBag } from "lucide-react";

interface SwiftMartLogoProps {
  className?: string;
  iconOnly?: boolean;
}

export default function SwiftMartLogo({
  className = "",
  iconOnly = false,
}: SwiftMartLogoProps) {
  return (
    <div className={`flex items-center gap-2.5 select-none ${className}`}>
      {/* Logo Icon */}
      <div className="relative flex h-10 w-10 items-center justify-center rounded-xl bg-linear-to-br from-indigo-600 to-violet-500 shadow-md shadow-indigo-500/20 dark:from-indigo-500 dark:to-purple-500">
        {/* Abstract "S" / Fast Forward Arrow Overlay */}
        <div className="absolute inset-0 flex items-center justify-center opacity-20">
          <svg
            viewBox="0 0 24 24"
            fill="none"
            stroke="currentColor"
            strokeWidth="3"
            className="h-6 w-6 text-white"
          >
            <path
              d="M13 5l7 7-7 7M4 5l7 7-7 7"
              strokeLinecap="round"
              strokeLinejoin="round"
            />
          </svg>
        </div>

        {/* Core Shopping Bag Icon */}
        <ShoppingBag className="h-5 w-5 text-white stroke-[2.5]" />
      </div>

      {/* Logo Text (Hidden if iconOnly is true) */}
      {!iconOnly && (
        <span className="text-xl font-bold tracking-tight text-slate-900 dark:text-slate-50">
          swift
          <span className="bg-linear-to-r from-indigo-600 to-violet-500 bg-clip-text text-transparent dark:from-indigo-400 dark:to-purple-400">
            mart
          </span>
        </span>
      )}
    </div>
  );
}
