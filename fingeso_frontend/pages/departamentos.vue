<template>
  <v-app>
    <v-container>
      <v-card>
        <v-card-title>Lista de Departamentos</v-card-title>
        <v-list>
          <v-list-item-group v-for="dept in depts" :key="dept.id_departamento">
            <v-list-item>
              <v-list-item-content>
                <v-list-item-title
                  >Departamento N°:
                  {{ dept.id_departamento }}</v-list-item-title
                >
                <v-list-item-subtitle>
                  Residente: {{ dept.residente.nombre }}
                </v-list-item-subtitle>
                <v-list-item-subtitle v-if="dept.estacionamiento"
                  >Estacionamiento: Sí</v-list-item-subtitle
                >
                <v-list-item-subtitle v-else
                  >Estacionamiento: No</v-list-item-subtitle
                >
                <v-list-item-subtitle v-if="dept.bodega"
                  >Bodega: Sí</v-list-item-subtitle
                >
                <v-list-item-subtitle v-else>Bodega: No</v-list-item-subtitle>
              </v-list-item-content>
            </v-list-item>
          </v-list-item-group>
        </v-list>
      </v-card>
    </v-container>
  </v-app>
</template>

<script>
export default {
  layout: "layout2",
  name: "departamentos",
  data() {
    return {
      idEdificio: "",
      depts: [],
    };
  },
  created() {
    this.idEdificio = this.$route.params.id;
    this.getData();
  },
  methods: {
    async getData() {
      try {
        let response = await this.$axios.get(
          "/departamento/deptsPorEdificio/" + this.idEdificio
        );
        this.depts = response.data;
      } catch (error) {
        console.log("error", error);
      }
    },
  },
};
</script>