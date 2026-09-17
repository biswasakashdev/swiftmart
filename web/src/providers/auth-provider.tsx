import { AuthContext } from "@/context/auth.context"
import { FullScreenLoader } from "@/components/loading"
import type { Authorization } from "@/types/user.types"
import axios from "axios"
import { useEffect, useState } from "react"

export const AuthContextProvider = ({
  children,
}: {
  children: React.ReactNode
}) => {
  const [authorization, setAuthorization] = useState<Authorization | undefined>(
    undefined
  )

  useEffect(() => {
    const fetchAuthorization = async () => {
      const res = await axios.get("/api/v1/auth")

      const { status, data } = res

      if (status === 200) {
        setAuthorization(data)
      }
    }

    fetchAuthorization()
  }, [])

  if (!authorization) {
    return <FullScreenLoader message="Authenticating session..." />
  }

  const instance = axios.create({
    baseURL: "/",
    headers: {
      Authorization: authorization.token,
      "Content-Length": "application/json",
    },
  })

  return (
    <AuthContext.Provider
      value={{
        token: authorization.token,
        client: instance,
      }}
    >
      {children}
    </AuthContext.Provider>
  )
}
