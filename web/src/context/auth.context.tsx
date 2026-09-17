"use client"

import axios, { type AxiosInstance } from "axios"
import { createContext, useContext } from "react"

export const AuthContext = createContext<{
  client: AxiosInstance
  token: string | undefined
}>({
  client: axios,
  token: "",
})

const useAuthContext = () => {
  return useContext(AuthContext)
}

export default useAuthContext
