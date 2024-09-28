import { createGlobalStyle } from 'styled-components';

const GlobalStyle = createGlobalStyle`
  body {
    margin: 0;
    padding: 0;
    box-sizing: border-box;
    font-family: 'Roboto', sans-serif;
    background-color: #4a148c;
    color: #4a148c;
  }

  h1 {
    text-align: center;
    color: #4a148c;
  }

  a {
    color: #6a1b9a;
  }

  button {
    background-color: #6a1b9a;
    color: white;
    border: none;
    padding: 10px 20px;
    cursor: pointer;
    &:hover {
      background-color: #4a148c;
    }
  }
`;

export default GlobalStyle;
