<template>
  <div>
    <h1 v-if="user" class="user-name">Bienvenid@ {{ this.user.nombre }}</h1>
    <p class="text-center">
      Usted acaba de ingresar en la plataforma. Esta diseñada con el fin de
      favorecer el uso simple de las cuentas de la comunidad establecida para
      que se tenga una experiencia más fluida.
    </p>
    <br />
    <br />
    <v-btn width="300" height="50" @click="edificios()"> Edificios </v-btn>
  </div>
</template>

<script>
export default {
  layout: "layout2",
  name: "user1",
  data() {
    return {
      id: "",
      user: null,
    };
  },
  created() {
    // Accede a los parámetros de la ruta en el ciclo de vida created
    this.user = this.$route.params.user;
    this.id = this.$route.params.user.id_admin;
  },
  methods: {
    async edificios() {
      this.$router.push({ name: "edificios_a", params: { id: this.id } });
    },
  },
};
</script>

<style scoped>
.user-name {
  font-weight: bold;
  color: #3498db;
  margin-bottom: 45px;
}
.large-text {
  font-size: 50px;
}
</style>