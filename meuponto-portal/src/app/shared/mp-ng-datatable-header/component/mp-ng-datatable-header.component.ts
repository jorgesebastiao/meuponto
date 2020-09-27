import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {FormBuilder, FormControl, FormGroup} from '@angular/forms';
import {debounceTime, distinctUntilChanged} from 'rxjs/operators';

@Component({
  selector: 'mp-ng-datatable-header',
  templateUrl: './mp-ng-datatable-header.component.html',
  styleUrls: ['./mp-ng-datatable-header.component.scss']
})
export class MpNgDatatableHeaderComponent implements OnInit {

  @Input() buttonTitle: string;
  @Input() brand: string;
  @Input() placeholder: string;
  @Output() searchChange: EventEmitter<any> = new EventEmitter();
  @Output() newRegisterChange: EventEmitter<any> = new EventEmitter();
  searchForm: FormGroup;
  searchControl: FormControl;

  constructor(private formBuilder: FormBuilder) {
  }

  ngOnInit() {
    this.searchControl = this.formBuilder.control('');
    this.searchForm = this.formBuilder.group({
      search: this.searchControl
    });

    this.searchControl.valueChanges.pipe(debounceTime(500),
      distinctUntilChanged())
      .subscribe(search => this.searchChange.emit({search}));
  }

  newRegisterChanged() {
    this.newRegisterChange.emit();
  }
}
