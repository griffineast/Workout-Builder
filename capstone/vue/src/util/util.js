


export function isTrainer() {
    const user = this.$store.state.user;
    if (!user) return false;
    return user.authorities.findIndex((u) => u.name === "ROLE_ADMIN") > -1;
  }

  