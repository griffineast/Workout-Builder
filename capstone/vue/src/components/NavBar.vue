<template>
  <div class="nav-bar">
    <nav class="navbar navbar-expand-lg navbar-light bg-light shadow">
      <router-link
        class="navbar-brand"
        v-bind:to="{ name: 'home' }"
        
      >
        <img
          src="/img/logo.png"
          width="30"
          height="30"
          alt=""
      /></router-link>

      <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
        <div class="navbar-nav">
          <router-link
            class="nav-item nav-link active"
            v-bind:to="{ name: 'home' }"
           
            >Home
          </router-link>
          <router-link
            class="nav-item nav-link active"
            v-bind:to="{ name: 'Exercise' }"
            v-if="$store.state.token != ''"
            >Exercises</router-link
          >
        </div>
      </div>
      <router-link
        class="logout nav-item nav-link active mr-auto"
        v-bind:to="{ name: 'logout' }"
        v-if="$store.state.token != ''"
        >Logout</router-link
      >
    </nav>

    <!-- <nav class="navbar navbar-expand-lg navbar-light bg-light">
      <router-link
        class="navbar-brand"
        v-bind:to="{ name: 'home' }"
        v-if="$store.state.token != ''"
        >Workout Builder</router-link
      >

      <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
          <li class="nav-item active">
            <router-link
              class="nav-item nav-link active"
              v-bind:to="{ name: 'home' }"
              v-if="$store.state.token != ''"
              >Home
            </router-link>
          </li>

          <li class="nav-item dropdown">
            <router-link
              class="nav-link dropdown-toggle"
              href="#"
              id="navbarDropdown"
              role="button"
              data-toggle="dropdown"
              aria-haspopup="true"
              aria-expanded="false"
              v-bind:to="{ name: 'Exercise' }"
              v-if="$store.state.token != ''"
              >Exercises</router-link
            >

            <div class="dropdown-menu" aria-labelledby="navbarDropdown">
              <router-link
                class="dropdown-item"
                v-bind:to="{ name: 'Exercise' }"
                v-if="$store.state.token != ''"
                >View Exercises</router-link
              >
              <router-link
                class="dropdown-item"
                v-bind:to="{ name: 'Exercise' }"
                v-if="$store.state.token != ''"
                >Add Exercises</router-link
              >
              <div class="dropdown-divider"></div>
              <a class="dropdown-item" href="#">Something else here</a>
            </div>

            <router-link
              class="logout nav-item nav-link active mr-sm-2"
              v-bind:to="{ name: 'logout' }"
              v-if="$store.state.token != ''"
              >Logout</router-link
            >
          </li>
        </ul>
      </div>
    </nav> -->
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

.nav-bar {
  margin-bottom: 50px;
}
</style>
