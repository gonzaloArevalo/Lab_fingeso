<template>
  <v-app>
    <v-container>
      <v-card>
        <v-card-title>Lista de Edificios</v-card-title>

        <v-list>
          <v-list-item-group v-for="edificio in edificios" :key="edificio.id">
            <v-list-item @click="verDepts(edificio.id_edificio)">
              <v-list-item-content>
                <v-list-item-title
                  >ID del Edificio:
                  {{ edificio.id_edificio }}</v-list-item-title
                >
                <v-list-item-subtitle>
                  Departamentos Totales: {{ edificio.departamentosTotales }}
                </v-list-item-subtitle>
                <v-list-item-subtitle>
                  Departamentos Ocupados: {{ edificio.departamentosOcupados }}
                </v-list-item-subtitle>
              </v-list-item-content>

              <v-list-item-action>
                <v-btn @click="addGasto(edificio.id_edificio)" color="primary"
                  >Añadir Gasto Común</v-btn
                >
              </v-list-item-action>
            </v-list-item>
          </v-list-item-group>
        </v-list>
      </v-card>
    </v-container>
  </v-app>
</template>

<script>
import axios from "axios";

export default {
  layout: "layout2",
  name: "edificios_a",
  data() {
    return {
      edificios: [],
    };
  },
  methods: {
    async getData() {
      const response = await this.$axios.get("/edificio/getAll");
      this.edificios = response.data;
    },
    verDepts(idEdificio) {
      this.$router.push({ name: "departamentos", params: { id: idEdificio } });
    },
    addGasto(idEdificio) {
      this.$router.push({ name: "add_gasto", params: { id: idEdificio } });
    },
  },
  created() {
    this.getData();
  },
};
</script>
  