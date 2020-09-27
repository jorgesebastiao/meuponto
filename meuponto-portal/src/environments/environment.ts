export const environment = {
  production: false,
  apiUrl: 'http://localhost:8080/api',
  clientId: 'meupontoapiangular',
  secretId: 'm3up@nt@@p1@ngul@r',
  tokenName: 'meupontoToken',
  tokenWhitelistedDomains: ['localhost:4200', 'localhost:8080'],
  tokenBlacklistedRoutes: [new RegExp('\/oauth\/token')]
};
