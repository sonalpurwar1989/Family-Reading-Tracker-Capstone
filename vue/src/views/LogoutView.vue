<template>
  <div class="logout">
    <h1>Logout</h1>
  </div>
</template>
<script>
export default {
  created() {
    this.$store.commit("LOGOUT");
    this.$router.push("/login");
  }
};
</script>
<style scoped>
.logout {
  background-color: #FFF5EA; 
  text-align: center;
  padding: 50px;
  font-family: 'Arial', sans-serif;
}
h1 {
  color: #FF6F61; 
  font-size: 36px;
  font-weight: bold;
}
</style>