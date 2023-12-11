<template>
    <div>
        <h1>Su Deuda es</h1>
        <table>
            <th>Monto</th>
            <td>
                <span>{{ items }}</span>
            </td>
        </table>
    </div>
</template>

<script>
export default{
    name: 'deudaspR',
    layout: 'layout2',
    data(){
        return{
            id: '',
            items: [],
        };
    },
    created(){
        this.id = this.$route.params.id;
        this.getData();
    },
    methods:{
        getData: async function () {
            try{
                let response = await this.$axios.get('/deuda/deudasPorResidente/'+ this.id);
                this.items = response.data;
                console.log(response);
            }catch (error) {
                console.log('error', error);
            }
        },
    }

}
</script>