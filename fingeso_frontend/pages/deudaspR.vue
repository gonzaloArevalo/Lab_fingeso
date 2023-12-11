<template>
        <v-app>
            <v-container>
                <v-card>
                    <v-card-title>Su Deuda es</v-card-title>
                    <v-list>
                        <v-list-item-group v-for="deuda in items" :key="deuda.monto">
                            <v-list-item>
                                <v-list-item-content>
                                    <v-list-item-title> Monto a Pagar {{ deuda.monto }}</v-list-item-title>
                                    <v-list-item-subtitle>Descripcion: {{ deuda.descripcion_deuda }}</v-list-item-subtitle>
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
    name: 'deudaspR',
    layout: 'layout2',
    data() {
        return {
            id: '',
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
                let response = await this.$axios.get('/deuda/deudasPorResidente/' + this.id);
                this.items = response.data;
                console.log(response);
            } catch (error) {
                console.log('error', error);
            }
        },
    }

}
</script>
