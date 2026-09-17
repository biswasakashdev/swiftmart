export interface Authorization {
  token: string
}

export interface UserProfile {
  id: string
  firstName: string
  lastName: string
  email: string
  avatar?: string
}

export interface UserCredentials {
  email: string
  password: string
}
