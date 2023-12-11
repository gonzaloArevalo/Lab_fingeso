<template>
  <v-app light>
    
    <v-app-bar :clipped-left="clipped" fixed app>
      
      
      
      
      <v-toolbar-title>{{ title }}</v-toolbar-title>
      <v-spacer />
      
    </v-app-bar>
    <v-main>
      <v-container>
        <Nuxt />
      </v-container>
    </v-main>
    
    <v-footer :absolute="!fixed" app>
      <span>&copy; {{ new Date().getFullYear() }}</span>
    </v-footer>
  </v-app>
</template>

<script>
export default {
  name: "DefaultLayout",
  data() {
    return {
      clipped: false,
      drawer: false,
      fixed: false,
      items: [
        {
          icon: "mdi-apps",
          title: "Welcome",
          to: "/",
        },
        {
          icon: "mdi-chart-bubble",
          title: "Inspire",
          to: "/inspire",
        },

        {
          icon: "mdi-cash-multiple",
          title: "Deudas",
          to: "/DeudasR",
        },
        {
          icon: "mdi-account",
          title: "SubAdmin",
          to: "/SubAdmin",
        },
      ],
      miniVariant: false,
      right: true,
      rightDrawer: false,
      title: "",
    };
  },
};
</script>
