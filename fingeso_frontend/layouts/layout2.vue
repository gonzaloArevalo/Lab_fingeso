<script>
export default {
  name: "layout2",
  data() {
    return {
      clipped: false,
      drawer: false,
      fixed: false,
      title: "ADCe",
    };
  },
};
</script>

<template>
  <v-app>
    <v-app-bar 
    height="60px"
    app
    color="blue">
    
    <v-container>
      <v-toolbar-title> ADCe </v-toolbar-title> 
    </v-container>

      <v-spacer />
      <v-btn href="/">
        Logout
      </v-btn>
    </v-app-bar>

    <v-main>
      <Nuxt />
    </v-main>

    <v-footer :absolute="!fixed" app style="background-color: rgb(31, 121, 194); color: white;">
      <span>&copy; {{ new Date().getFullYear() }}</span>
    </v-footer>

  </v-app>
</template>

<style>
</style>