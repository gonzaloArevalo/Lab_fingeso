
<template>
  <v-app>
    <v-container>
      <v-card>
        <v-card-title>Mis Deudas</v-card-title>
        <v-list>
          <v-list-item-group v-for="deuda in items" :key="deuda.monto">
            <v-list-item>
              <v-list-item-content>
                <v-list-item-title>
                  Monto a Pagar: $ {{ deuda.monto }}</v-list-item-title
                >
                <v-list-item-subtitle
                  >Descripcion:
                  {{ deuda.descripcion_deuda }}</v-list-item-subtitle
                >
              </v-list-item-content>
            </v-list-item>
          </v-list-item-group>
        </v-list>
        <v-btn
      width="300px"
      height="50px"
      href="https://login.portal.bancochile.cl/bancochile-web/persona/login/#/login"
      >Pagar</v-btn
    >
      </v-card>
    </v-container>
  </v-app>
</template>


<script>
export default {
  name: "deudas_r",
  layout: "layout2",
  data() {
    return {
      id: "",
      items: [],
    };
  },
  created() {
    this.id = this.$route.params.id;
    this.getData();
  },
  methods: {
    getData: async function () {
      try {
        let response = await this.$axios.get(
          "/deuda/deudasPorResidente/" + this.id
        );
        this.items = response.data;
      } catch (error) {
        console.log("error", error);
      }
    },
  },
};
</script>