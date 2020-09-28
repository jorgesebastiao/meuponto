import { Inject } from '@angular/core';
import { Component, OnInit } from '@angular/core';
import { AbstractControl, FormBuilder, FormGroup, Validators } from '@angular/forms';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';
import { ToastrService } from 'ngx-toastr';
import { FormService } from 'src/app/shared/services/form.service';
import { CustomerUpdateComand, CustomerCreateCommand } from '../shared/customer.model';
import { CustomerService } from '../shared/customer.service';

@Component({
    selector: 'mp-customer-edit',
    templateUrl: './customer-edit.component.html',
    styleUrls: ['./customer-edit.component.scss']
})
export class CustomerEditComponent implements OnInit {
    isLoading: boolean;
    isEdit: boolean;
    customerForm: FormGroup;
    customerId: number;

    constructor(
        public dialogRef: MatDialogRef<CustomerEditComponent>,
        @Inject(MAT_DIALOG_DATA)
        public data: any,
        private formBuilder: FormBuilder,
        private formService: FormService,
        private customerService: CustomerService,
        private toastrService: ToastrService
    ) {

    }

    ngOnInit() {
        this.isEdit = false;
        this.customerId = this.data.customerId;
        this.initForms();
        if (this.customerId) {
            this.isEdit = true;
            this.getCustomer();
        }
    }

    private initForms() {
        this.customerForm = this.formBuilder.group({
            cnpj: this.formBuilder.control(''),
            corporateName: this.formBuilder.control('', [Validators.required]),
            tradeName: this.formBuilder.control('', [Validators.required])
        });
    }

    save(){
        if (this.customerForm.valid) {
            this.isLoading = true;
            if (this.isEdit) {
                const customerUpdateComand: CustomerUpdateComand = new  CustomerUpdateComand(this.customerForm.value, this.customerId);
                this.customerService.put(customerUpdateComand)
                    .subscribe(() => {
                        this.toastrService.success('Edição realizada com Sucesso!');
                        this.isLoading = false;
                        this.dialogRef.close(true);
                    }, error => {
                        this.isLoading = false;
                        const errorMessage = error.status == 400 ? error.error.message: 'Ocorreu erro ao processar a solicitação';
                        this.toastrService.error(errorMessage);
                    });
            } else {
               const  customerCreateCommand:  CustomerCreateCommand = new  CustomerCreateCommand(this.customerForm.value);
                this.customerService.post(customerCreateCommand)
                    .subscribe(() => {
                        this.toastrService.success('Cadastro realizado com Sucesso!');
                        this.isLoading = false;
                        this.dialogRef.close(true);
                    }, error => {
                        this.isLoading = false;
                        const errorMessage = error.status == 400 ? error.error.message: 'Ocorreu erro ao processar a solicitação';
                        this.toastrService.error(errorMessage);
                    });
            }
        } else {
            this.formService.validForm(this.customerForm);
        }   
    }

    getCustomer() {
        this.isLoading = true;
        this.customerService.getById(this.customerId).subscribe(customerResponse => {
            this.customerForm.patchValue(customerResponse);
            this.isLoading = false;
        }, error => {
            this.isLoading = false;
            this.toastrService.error('Ocorreu erro na solicitação');
        });
    }
}