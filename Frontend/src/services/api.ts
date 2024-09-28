import axios from 'axios';

const api = axios.create({
  baseURL: '/',
});

export const cadastrarPessoa = async (pessoa: any) => {
  try {
    const response = await api.post('/person', pessoa);
    return response.data;
  } catch (error) {
    throw error;
  }
};

export const relatorioPessoas = async () => {
  try {
    const response = await api.get('/person');
    console.log(response.data);
    return response.data;
  } catch (error) {
    console.error('Erro ao buscar dados das pessoas:', error);
    throw error;
  }
};

export const consultaCEP = async (cep: any) => {
  try {
    const retorno = await axios.get(`https://viacep.com.br/ws/${cep}/json/`);
    return retorno.data;
  } catch (error) {
    console.error('Erro ao buscar CEP', error);
    throw error;
  }
}

export const solicitarGeracaoRelatorio = async () => {
  const response = await axios.get('/report');
  console.log("---------------------------");
  console.log(response);
  return response.data;
};

export default api;
