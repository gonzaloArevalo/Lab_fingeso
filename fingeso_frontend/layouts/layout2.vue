<template>
  <v-app>
        <v-app-bar 
        height="60px"
        app
        color="blue">
        
        <v-container class="text-center">
          <v-toolbar-title> Titulo </v-toolbar-title> 
        </v-container>

          <v-spacer />
          <v-btn href="/">
            Logout
          </v-btn>
        </v-app-bar>

    <v-main>
      <Nuxt />
    </v-main>

  </v-app>
</template>

<style>
</style>