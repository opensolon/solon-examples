service UserService {
  User getUser(1: i32 id);
}

struct User {
  1: i32 id,
  2: string name,
  3: i32 age,
}