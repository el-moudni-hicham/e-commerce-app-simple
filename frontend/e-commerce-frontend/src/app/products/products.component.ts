import { Component } from '@angular/core';
import {HttpClient} from "@angular/common/http";

@Component({
  selector: 'app-products',
  templateUrl: './products.component.html',
  styleUrls: ['./products.component.css']
})
export class ProductsComponent {
  products : any;
  public constructor(private http:HttpClient) {
    this.http.get("http://localhost:9999/inventory-service/products?projection=fullProduct").subscribe({
      next : data => {
        this.products=data;
      },
      error : err => {

      }
    })

  }
}
