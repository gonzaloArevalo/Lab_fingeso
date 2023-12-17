<script>
  export default {
    name: "DefaultLayout",
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
      <v-toolbar-title class="font-italic font-weight-bold"> ADCe </v-toolbar-title> 
    </v-container>

      <v-spacer />
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
.font-italic {
    font-style: italic;
  }

  .font-weight-bold {
    font-weight: bold;
  }
</style>