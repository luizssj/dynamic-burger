import { DynamicBurgerWebPage } from './app.po';

describe('dynamic-burger-web App', () => {
  let page: DynamicBurgerWebPage;

  beforeEach(() => {
    page = new DynamicBurgerWebPage();
  });

  it('should display welcome message', () => {
    page.navigateTo();
    expect(page.getParagraphText()).toEqual('Welcome to app!!');
  });
});
