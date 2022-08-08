import { animate, style, transition, trigger } from '@angular/animations';
import { Component, OnDestroy, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { finalize, Subscription } from 'rxjs';
import { AuthService } from 'src/app/core/auth/auth.service';
import { AutoLoginService } from 'src/app/core/services/auto-login.service';

@Component({
  selector: 'app-login-form',
  templateUrl: './login-form.component.html',
  styleUrls: ['./login-form.component.scss'],
  animations: [
    trigger('fade', [
      transition(':enter', [
        style({ opacity: 0 }),
        animate(100, style({ opacity: 1 })),
      ]),
      transition(':leave', [
        style({ opacity: 1 }),
        animate(100, style({ opacity: 0 })),
      ]),
    ]),
  ],
})
export class LoginFormComponent implements OnInit, OnDestroy {
  private _authSub = new Subscription();

  username = '';
  password = '';
  autoLogin = false;
  passwordType: 'password' | 'text' = 'password';
  isPasswordShown = false;
  isSigningIn = false;
  isTooltipVisible = false;

  constructor(
    private authService: AuthService,
    private autoLoginService: AutoLoginService,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.autoLogin = this.autoLoginService.isAutoLoginEnabled();
  }

  ngOnDestroy(): void {
    this._authSub.unsubscribe();
  }

  login(): void {
    this.isSigningIn = true;
    this._authSub = this.authService
      .auth(this.username, this.password)
      .pipe(finalize(() => (this.isSigningIn = false)))
      .subscribe({
        complete: () => this.router.navigate(['home']),
        error: (err) =>
          alert(
            err.status
              ? 'Usuário ou senha inválidos'
              : 'Sem resposta do servidor'
          ),
      });
  }

  toggleShowPassword(): void {
    this.isPasswordShown = !this.isPasswordShown;
    this.passwordType = this.isPasswordShown ? 'text' : 'password';
  }

  showTooltip(): void {
    this.isTooltipVisible = true;
  }
  hideTooltip(): void {
    this.isTooltipVisible = false;
  }
  toggleTooltip(): void {
    this.isTooltipVisible = !this.isTooltipVisible;
  }

  setAutoLogin(value: boolean): void {
    this.autoLoginService.setAutoLogin(value);
  }
}
