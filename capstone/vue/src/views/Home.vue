<template>
  <div class="home">
   <display-exercises/>
   <user-column/>
  </div>
</template>

<script>
import UserColumn from '../components/UserColumn.vue';

export default {
  name: "Home",
  components: {
    UserColumn
  }
}

</script>
