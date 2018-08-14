import { Component, ViewChild, OnInit } from '@angular/core';
import { NewsBulletinService } from './news-bulletin.service';
import { MatPaginator, MatSort, MatTableDataSource } from '@angular/material';
import { NewsBulletinVO } from './news-bulletin.model';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  displayedColumns: string[] = ['id', 'newsText', 'publisherName', 'newPublishTime'];
  dataSource: MatTableDataSource<NewsBulletinVO>;

  @ViewChild(MatPaginator) paginator: MatPaginator;
  @ViewChild(MatSort) sort: MatSort;

  constructor(private newsBulletinService: NewsBulletinService) {

    newsBulletinService.findAllNewsBulletins().subscribe(
      response => {
        console.log(response);

        // Create 100 users
        const newBulletins: any[] = response;

        // Assign the data to the data source for the table to render
        this.dataSource = new MatTableDataSource(newBulletins);
        this.dataSource.paginator = this.paginator;
        this.dataSource.sort = this.sort;
      },
      error => console.log(error)
    );

  }

  ngOnInit() {
  }

  applyFilter(filterValue: string) {
    this.dataSource.filter = filterValue.trim().toLowerCase();

    if (this.dataSource.paginator) {
      this.dataSource.paginator.firstPage();
    }
  }

  // createNewsBulletin(id: number): NewsBulletinVO {

  //   return {
  //     id: id.toString(),
  //     name: name,
  //     progress: Math.round(Math.random() * 100).toString(),
  //     color: COLORS[Math.round(Math.random() * (COLORS.length - 1))]
  //   };
  // }
}
