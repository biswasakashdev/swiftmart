import useAuthContext from "@/context/auth.context"
import { UserContext } from "@/context/user.context"
import { FullScreenLoader } from "@/components/loading"
import { type UserProfile } from "@/types/user.types"
import { useEffect, useState } from "react"
import { useNavigate } from "react-router"

export const UserProvider = ({ children }: { children: React.ReactNode }) => {
  const navigate = useNavigate()
  const { client, token } = useAuthContext()
  const [userProfile, setUserProfile] = useState<UserProfile | undefined>(
    undefined
  )

  useEffect(() => {
    const fetchUser = async () => {
      if (token === undefined) {
        navigate("/auth")
        return
      }

      try {
        const query = {
          query: `
            query GetUser {
              user {
                id
                name
                email
                avatar
              }
            }
          `,
        }

        const res = await client.post("/", query)

        const user = res.data?.data?.user || res.data?.user
        if (user) {
          const [firstName = "", ...rest] = (user.name || "")
            .trim()
            .split(/\s+/)
          const lastName = rest.join(" ")

          setUserProfile({
            id: "",
            firstName: user.firstName || firstName,
            lastName: user.lastName || lastName,
            email: user.email,
            avatar: user.avatar,
          })
        }
      } catch (error) {
        console.error("Failed to fetch user:", error)
        navigate("/auth")
      }
    }

    fetchUser()
  }, [client, token, navigate])

  if (!userProfile) {
    return <FullScreenLoader message="Setting up your account..." />
  }

  return (
    <UserContext.Provider value={userProfile}>{children}</UserContext.Provider>
  )
}
