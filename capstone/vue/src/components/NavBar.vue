<template>
  <div class="nav-bar">
    <nav class="navbar navbar-expand-sm navbar-light bg-light shadow py-3">
      <router-link class="navbar-brand" v-bind:to="{ name: 'home' }">
        <img src="/img/logo.png" width="50" height="50" alt="" />
        Workout Builder
      </router-link>

      <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
        <div class="navbar-nav ms-auto">
          <router-link
            class="nav-item nav-link active"
            v-bind:to="{ name: 'home' }"
            >Home
          </router-link>

          <router-link
            class="home-btn nav-item nav-link active"
            v-bind:to="{ name: 'Exercise' }"
            v-if="$store.state.token != ''"
            >Exercises</router-link
          >

          <router-link
            class="logout nav-item nav-link active"
            v-bind:to="{ name: 'logout' }"
            v-if="$store.state.token != ''"
            >Logout</router-link
          >
        </div>
      </div>
    </nav>
  </div>
</template>

<script>
export default {};
</script>

<style>
.logout {
  margin-right: 50px;
}

.navbar-brand {
  margin-left: 50px;
}

.navbar-brand:hover img {
  transition: all 0.2s ease-in-out;
  transform: scale(1.1);
}

.nav-item {
  font-size: 20px;
}


.nav-link {
  color: darkgray !important;
}

.nav-link:hover {
  color: red !important;
  transition: all 0.2s ease-in-out;
  transform: scale(1.1);
}

.nav-bar {
  margin-bottom: 5px;
}
</style>
