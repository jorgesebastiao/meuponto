export class CustomerCreateCommand {
    public cnpj: string;
    public corporateName: string;
    public tradeName: string;
    constructor(customer: any) {
      this.cnpj = customer.cnpj;
      this.corporateName = customer.corporateName;
      this.tradeName = customer.tradeName;
    }
  }
  
  export class CustomerUpdateComand {
    public id: number;
    public corporateName: string;
    public tradeName: string;
    constructor(customer: any, customerId: number) {
      this.corporateName = customer.corporateName;
      this.tradeName = customer.tradeName;
      this.id = customerId;
    }
  }

  export class CustomerViewModel{
    public id: number;
    public cnpj: string;
    public corporateName: string;
    public tradeName: string;

    constructor(customer: any) {
      this.id = customer.id;
      this.cnpj = customer.cnpj;
      this.corporateName = customer.corporateName;
      this.tradeName = customer.tradeName;
    }
  }