import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { Todo } from 'src/app/Models/Todo';
import { TodoService } from 'src/app/services/todo.service';

@Component({
  selector: 'app-create',
  templateUrl: './create.component.html',
  styleUrls: ['./create.component.css']
})
export class CreateComponent {

  todo: Todo = {
    titulo:'',
    descricao: '',
    dataParaFinalizar: new Date(),
    finalizado:false,
    
  }
  constructor(private router: Router, private service: TodoService) { }
  
  ngOnInit(): void {
  }

  create(): void{
    this.formataData()
    this.service.create(this.todo).subscribe((resposta) => {
      this.service.message('ToDo Criado Com Sucesso');
      this.router.navigate(['']);
    }, erro => {
      this.service.message('Falha ao Criar ToDo');
      this.router.navigate(['']);
    } )
  }

  cancel(): void{
      this.router.navigate([''])
  }

  formataData(): void{
    let data = new Date(this.todo.dataParaFinalizar)
    this.todo.dataParaFinalizar = `${data.getDate()}/${data.getMonth() + 1}/${data.getFullYear()}`
  }


}
