export const environment = {
  production: true,
  apiUrl: 'http://localhost:8080/api',
  clientId: 'meupontoapiangular',
  secretId: 'm3up@nt@@p1@ngul@r',
  tokenName: 'meupontoToken',
  tokenWhitelistedDomains: ['localhost:8080'],
  tokenBlacklistedRoutes: [new RegExp('\/oauth\/token')]
};
