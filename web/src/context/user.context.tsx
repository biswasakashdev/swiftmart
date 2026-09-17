import { type UserProfile } from "@/types/user.types"
import { createContext, useContext } from "react"

export const UserContext = createContext<UserProfile>({
  id: "",
  email: "",
  firstName: "",
  lastName: "",
})

export default function useUserContext() {
  return useContext(UserContext)
}
