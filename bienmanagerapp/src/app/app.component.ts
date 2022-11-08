import { HttpErrorResponse, HttpResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Bien } from './bien';
import { BienService } from './bien.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  title='Angular-SpringBoot';
  public biens: Bien[] | any;

  
  constructor (private bienService: BienService) {}

  ngOnInit(): void {
      this.getBiens();
  }

    public getBiens(): void {
      this.bienService.getBiens().subscribe(
        (response:Bien[]) => {
          this.biens = response;
        },
        (error:HttpErrorResponse) => {
          alert(error.message)
        }
      )
    }
  }

//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