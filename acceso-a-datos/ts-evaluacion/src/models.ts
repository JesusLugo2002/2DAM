export enum Role {
  USER = "USER",
  ADMIN = "ADMIN"
}

export type Task = {
  id: string;
  title: string;
  completed: boolean;
  createdAt: Date;
};

export type JwtPayload = {
  sub: string;
  role: Role;
  exp: number; // unix timestamp (segundos)
};
