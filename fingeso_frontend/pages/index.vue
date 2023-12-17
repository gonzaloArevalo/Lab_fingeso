

<template>
  <v-container fluid>
    <v-card class="elevation-12 pa-8">
    <v-row class="text-center" style="flex-direction: column">
      <v-col
        cols="12"
        class="text-center"
        style="margin-bottom: 100px; margin-top: 50px"
      >
        <h1 style="color: rgb(46, 46, 114)">
          Seleccione una Opción para Iniciar Sesión
        </h1>
      </v-col>
      <v-col>
        <v-btn
          @click="loginAdmin"
          class="mx-2 my-2"
          style="font-size: 30px; padding: 30px; min-width: 200px"
          color="success"
        >
          LOGIN ADMIN</v-btn
          >
      </v-col>
      <v-col>
        <v-btn
          @click="loginSubadmin"
          class="mx-2 my-2"
          style="font-size: 30px; padding: 30px; min-width: 200px"
          color="success"
          >
          LOGIN SUBADMIN</v-btn
        >
      </v-col>
      <v-col>
        <v-btn
        @click="loginResident"
        class="mx-2 my-2"
        style="font-size: 30px; padding: 30px; min-width: 200px"
        color="success"
        >
          LOGIN RESIDENTE</v-btn
          >
      </v-col>
      <v-col>
        <v-btn
        @click="loginPersonal"
        class="mx-2 my-2"
        style="font-size: 30px; padding: 30px; min-width: 200px"
        color="success"
        >
          LOGIN PERSONAL</v-btn
          >
      </v-col>
    </v-row>
  </v-card>
  </v-container>
</template>

<script>
export default {
  name: "index",
  methods: {
    async loginAdmin() {
      this.$router.push({ name: "login", params: { userType: 1 } });
    },
    async loginResident() {
      this.$router.push({ name: "login", params: { userType: 2 } });
    },
    async loginSubadmin() {
      this.$router.push({ name: "login", params: { userType: 3 } });
    },
    async loginPersonal() {
      this.$router.push({ name: "login", params: { userType: 4 } });
    },
  },
};
</script>