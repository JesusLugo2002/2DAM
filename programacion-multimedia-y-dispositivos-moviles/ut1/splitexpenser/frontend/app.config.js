import "dotenv/config";

export default {
  extra: {
    apiUrl: process.env.API_URL,
    tokenKey: process.env.TOKEN_KEY,
  },
};
